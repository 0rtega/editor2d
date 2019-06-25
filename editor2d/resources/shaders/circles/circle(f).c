#version 430



layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};

out vec4 fragColor;

void main()
{
	fragColor = vec4(1,0,0,1);
}