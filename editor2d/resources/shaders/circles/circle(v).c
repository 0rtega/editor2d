#version 430


layout (location = 0) in vec3 vertex;

layout (location = 2) in vec3 currentPosition;
layout (location = 3) in int color;
layout (location = 4) in float radius;
layout (location = 5) in int colorBorder;
layout (location = 6) in float widthBorder;

layout (location = 7) in int hover;
layout (location = 8) in int colorHover;
layout (location = 9) in float widthHover;


layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};


out flat int colorOut;
out flat int colorBorderOut;
out flat int colorHoverOut;
out float hoverOut;
out float widthHoverOut;
out float widthBorderOut;
out float radiusOut;
out vec3 currentPositionOut;
out vec3 vertexOut;

void main()
{    

	currentPositionOut = currentPosition;
	colorOut = color;
	colorBorderOut = colorBorder;
	widthBorderOut = widthBorder;
	radiusOut = radius;
	vertexOut = vertex;
	hoverOut = hover;
	widthHoverOut = widthHover;
	colorHoverOut = colorHover;
	gl_Position =   vec4(vertex, 1.0);
}