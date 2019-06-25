#version 430

const vec4 worldMatrix1 = vec4(1,0,0,0);
const vec4 worldMatrix2 = vec4(0,1,0,0);
const vec4 worldMatrix3 = vec4(0,0,1,0);

layout (location=0) in vec3 position;
layout (location=2) in vec3 normal;


layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};

uniform vec3 currentPosition;
uniform vec3 scale;

out vec3 normals;
out vec3 positionInWorld;

void main()
{    
	 mat4 worldMatrix = mat4(worldMatrix1, worldMatrix2, worldMatrix3, vec4(currentPosition, 1));
   	 worldMatrix [0][0] = scale.x;
   	 worldMatrix [1][1] = scale.y;
   	 worldMatrix [2][2] = scale.z;
   	 positionInWorld = vec3(worldMatrix  *  vec4(position, 1.0));
  	 normals = normal;
   	 gl_Position =  projectionMatrix * viewMatrix * worldMatrix * vec4(position, 1.0);
}