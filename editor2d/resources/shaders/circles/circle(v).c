#version 430

const vec4 worldMatrix1 = vec4(1,0,0,0);
const vec4 worldMatrix2 = vec4(0,1,0,0);
const vec4 worldMatrix3 = vec4(0,0,1,0);
float [21] stepForScale = float[21]( 1, 1.2, 1.44, 1.7279, 2.0734, 2.4883, 2.9858, 3.5833, 4.2994, 5.1597,
			6.1912, 6.1912, 6.1912, 6.1912, 6.1912, 6.1912, 6.1912, 6.1912, 6.1912, 6.1912, 6.1912 );

layout (location = 0) in vec3 vertex;

layout (location = 2) in vec3 currentPosition;
layout (location = 3) in int color;
layout (location = 4) in float radius;

layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};

uniform int zoom;
out flat int colorOut;
void main()
{    
	float scale = radius * stepForScale[10 - zoom]/4;
	mat4 modelMatrix = mat4(worldMatrix1 , worldMatrix2 , worldMatrix3 , vec4(currentPosition, 1));
	modelMatrix [0][0] = scale;
    modelMatrix [1][1] = scale;
    modelMatrix [2][2] = scale;
	colorOut = color;
	gl_Position = projectionMatrix * viewMatrix * modelMatrix *  vec4(vertex, 1.0);
}