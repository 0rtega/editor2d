#version 430

const vec4 worldMatrix1 = vec4(1,0,0,0);
const vec4 worldMatrix2 = vec4(0,1,0,0);
const vec4 worldMatrix3 = vec4(0,0,1,0);

layout (location=0) in vec3 position;
layout (location=1) in vec2 texCoord;

layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};

uniform vec3 currentPosition;
uniform float scale;

out  vec2 outTexCoord;

void main()
{    
	    mat4 worldMatrix = mat4(worldMatrix1 , worldMatrix2 , worldMatrix3 , vec4(currentPosition, 1));
	    worldMatrix [0][0] = scale;
	    worldMatrix [1][1] = scale;
	    worldMatrix [2][2] = scale;

		vec3 X = vec3( viewMatrix[0][0], viewMatrix[1][0], viewMatrix[2][0] );
        vec3 Y = vec3( viewMatrix[0][1], viewMatrix[1][1], viewMatrix[2][1] );

		vec3 vertex =   position.x * X + position.y * Y ;			  
	    gl_Position = projectionMatrix * viewMatrix * worldMatrix *  vec4(vertex, 1.0);
	    outTexCoord = texCoord;
}