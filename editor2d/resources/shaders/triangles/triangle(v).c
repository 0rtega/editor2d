
#version 430



layout (location = 0) in vec3 position;
layout (location = 5) in int color;
layout (location = 6) in int visible;


layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};

out flat int visible1;
out vec3 positionInWorld;
out flat int color1;

void main()
{    
	 

		visible1 = visible;
		color1 = color;
		positionInWorld = vec3(position);
   	 	gl_Position =  projectionMatrix * vec4(position, 1.0);



	
}