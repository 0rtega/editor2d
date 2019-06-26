#version 430



layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};

out vec4 fragColor;
in flat int colorOut;
void main()
{
	fragColor = colors[colorOut];
}