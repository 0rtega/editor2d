#version 430


const vec4 worldMatrix1 = vec4(1,0,0,0);
const vec4 worldMatrix2 = vec4(0,1,0,0);
const vec4 worldMatrix3 = vec4(0,0,1,0);

layout (location=0) in vec3 vertex;
layout (location=2) in vec3 normal;


layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};


uniform vec3 position;
uniform vec3 scale;
uniform mat4 rotate;

out vec3 vPosition;
out vec3 vNormal;


void main() {
     mat4 uModelMatrix = mat4(worldMatrix1, worldMatrix2, worldMatrix3, vec4(position , 1));
	
     uModelMatrix [0][0] = scale.x;
     uModelMatrix [1][1] = scale.y;
     uModelMatrix [2][2] = scale.z;
     uModelMatrix  = uModelMatrix * rotate ;
	
     
    vec4 modelPosition = uModelMatrix  * vec4(vertex, 1);
    gl_Position = projectionMatrix * viewMatrix * modelPosition;
    
    vPosition = vec3(modelPosition.xyz);
    vNormal = normal;
}


