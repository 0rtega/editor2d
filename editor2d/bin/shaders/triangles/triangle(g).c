#version 430


vec3 lightColor = vec3(1, 1, 1);
float ambientStrength = 0.4;

layout(triangles) in;
layout(triangle_strip, max_vertices = 3) out;

in flat int visible1[];
in flat int color1[];
in vec3 positionInWorld[];

out vec4 color;


layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};

vec4 getColor(vec3 pos, vec3 norm, int c){
	vec3 ambient = ambientStrength * lightColor;				       
	vec3 lightDir = normalize(positionLightSource - pos);
	float diff = max(dot(norm, lightDir), 0.0);
	vec3 diffuse = diff * lightColor;				
	vec3 result =  (ambient + diffuse ) * vec3(colors[c]);		
	return vec4(result, colors[c].w); 
}

void main()
{
	if(visible1[0] == 1){


		vec3 ab = vec3(
		positionInWorld[0].x - positionInWorld[1].x,
		positionInWorld[0].y - positionInWorld[1].y,
		positionInWorld[0].z - positionInWorld[1].z);

		vec3 bc = vec3(
		positionInWorld[1].x - positionInWorld[2].x,
		positionInWorld[1].y - positionInWorld[2].y,
		positionInWorld[1].z - positionInWorld[2].z);
	
		vec3 normal = vec3(0,0,0);
		normal.x = ab.y * bc.z - ab.z * bc.y; 
		normal.y = ab.z * bc.x - ab.x * bc.z;
		normal.z = ab.x * bc.y - ab.y * bc.x;
	
		vec3 norm = normalize(normal);

		  	

		gl_Position =  gl_in[0].gl_Position;
		color = getColor(positionInWorld[0], norm, color1[0]);
		EmitVertex();
	
		gl_Position =  gl_in[1].gl_Position;
		color = getColor(positionInWorld[1], norm, color1[1]);
		EmitVertex();
	    
		gl_Position =  gl_in[2].gl_Position;
		color = getColor(positionInWorld[2], norm, color1[2]);
		EmitVertex();
	
		EndPrimitive();
	}else{
		EndPrimitive();
	}

}