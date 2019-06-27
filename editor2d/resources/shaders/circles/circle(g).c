#version 430

const vec4 worldMatrix1 = vec4(1,0,0,0);
const vec4 worldMatrix2 = vec4(0,1,0,0);
const vec4 worldMatrix3 = vec4(0,0,1,0);

float [21] stepForScale = float[21]( 1, 1.2, 1.44, 1.7279, 2.0734, 2.4883, 2.9858, 3.5833, 4.2994, 5.1597,
			6.1912, 6.1912, 6.1912, 6.1912, 6.1912, 6.1912, 6.1912, 6.1912, 6.1912, 6.1912, 6.1912 );


layout(triangles) in;
layout(triangle_strip, max_vertices = 15) out;

in flat int colorOut[];
in flat int colorBorderOut[];
in float widthBorderOut[];
in float radiusOut[];
in vec3 currentPositionOut[];
in vec3 vertexOut[];
in flat int colorHoverOut[];
in float hoverOut[];
in float widthHoverOut[];


out flat int color;

layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
	mat4 projectionMatrix;
	mat4 viewMatrix;
	vec4 [39] colors;
};

uniform int zoom;

void main(){
	vec4 a =   vec4(vertexOut[0],1);
	vec4 c =   vec4(vertexOut[1],1);
	vec4 b =   vec4(vertexOut[2],1);
	float delta = widthBorderOut[0] / radiusOut[0];
	vec4 a1 = vec4(a.x - ((a.x - c.x) * delta), a.y - ((a.y - c.y) * delta) , 0, 1);
	vec4 c1 = vec4(b.x - ((b.x - c.x) * delta), b.y - ((b.y - c.y) * delta) , 0, 1);
	
	float scale = (radiusOut[0] * stepForScale[10 - zoom])/4;
	mat4 modelMatrix = mat4(worldMatrix1 , worldMatrix2 , worldMatrix3 , vec4(currentPositionOut[0], 1));
	modelMatrix [0][0] = scale;
    modelMatrix [1][1] = scale;
    modelMatrix [2][2] = scale;
	mat4 mvp = projectionMatrix * viewMatrix * modelMatrix;
	
		gl_Position = mvp * a1;
		color = colorOut[0];
		EmitVertex();
		
		gl_Position =  mvp *c;
		color = colorOut[0];
		EmitVertex();
		
		gl_Position = mvp * c1;
		color = colorOut[0];
		EmitVertex();
	
	EndPrimitive();
	
		gl_Position = mvp * a;
		color = colorBorderOut[0];
		EmitVertex();
		
		gl_Position = mvp * a1;
		color = colorBorderOut[0];
		EmitVertex();
		
		gl_Position =  mvp *c1;
		color = colorBorderOut[0];
		EmitVertex();
	
	EndPrimitive();
	 
		gl_Position = mvp * a;
		color = colorBorderOut[0];
		EmitVertex();
		
		gl_Position =  mvp *c1;
		color = colorBorderOut[0];
		EmitVertex();
		
		gl_Position = mvp * b;
		color = colorBorderOut[0];
		EmitVertex();
	
	EndPrimitive();
	
	if(hoverOut[0] == 1){
		float delta = widthHoverOut[0] / radiusOut[0];
		vec4 a2 = vec4(((a.x - c.x) * delta), ((a.y - c.y) * delta) , 0, 1);
		vec4 c2 = vec4(((b.x - c.x) * delta), ((b.y - c.y) * delta) , 0, 1);
		delta += 0.1;
		vec4 a3 = vec4(((a.x - c.x) * delta), ((a.y - c.y) * delta) , 0, 1);
		vec4 c3 = vec4(((b.x - c.x) * delta), ((b.y - c.y) * delta) , 0, 1);
		
	
		gl_Position = mvp * a3;
		color = colorHoverOut[0];
		EmitVertex();
		
		gl_Position = mvp * a2;
		color = colorHoverOut[0];
		EmitVertex();
		
		gl_Position =  mvp *c2;
		color = colorHoverOut[0];
		EmitVertex();
	
	EndPrimitive();
	 
		gl_Position = mvp * a3;
		color = colorHoverOut[0];
		EmitVertex();
		
		gl_Position =  mvp *c2;
		color = colorHoverOut[0];
		EmitVertex();
		
		gl_Position = mvp * c3;
		color = colorHoverOut[0];
		EmitVertex();
	
	EndPrimitive();
		
		
	}
	
}