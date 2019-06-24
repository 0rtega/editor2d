#version 430

in vec4 color;


layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};

uniform vec4 colorId;
uniform float select;

out vec4 fragColor;

void main()
{	     	


		        if(select == 0){
		
					fragColor = color; 
				}else{
					fragColor = colorId;
				}
		        	             
}