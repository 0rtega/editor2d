#version 430

in  vec2 outTexCoord;

layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};

out vec4 fragColor;

uniform sampler2D texture_sampler;
uniform vec4 color;

uniform vec4 colorId;
uniform float select;

void main()
{
	vec4 tex = texture(texture_sampler, outTexCoord);
	vec4 col = color * tex;
	if(tex.w == 0){
		//col = vec4(0.984, 0.988, 0.773,1);
		col = vec4(0.560, 0.560, 0.560,0.5);
	}else if(tex.w == 1){
		
	}else{
		col = vec4(0.560, 0.560, 0.560, 1) * (1 - tex.w);
		col.w = 0.5;
	}
	if(select == 0){
		fragColor = col; 	
	}else{
		fragColor = colorId;
	}	
}