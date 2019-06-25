#version 430

const vec4 worldMatrix1 = vec4(1,0,0,0);
const vec4 worldMatrix2 = vec4(0,1,0,0);
const vec4 worldMatrix3 = vec4(0,0,1,0);

layout (location = 0) in vec3 vertex;

layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};

uniform vec3 currentPosition;
uniform float scale;
void main()
{    
	mat4 modelMatrix = mat4(worldMatrix1 , worldMatrix2 , worldMatrix3 , vec4(currentPosition, 1));
	modelMatrix [0][0] = scale;
    modelMatrix [1][1] = scale;
    modelMatrix [2][2] = scale;
	gl_Position = projectionMatrix * viewMatrix * modelMatrix *  vec4(vertex, 1.0);
}