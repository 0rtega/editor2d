#version 430

vec3 lightColor = vec3(1, 1, 1);
float ambientStrength = 0.5;

in vec3 normals;
in vec3 positionInWorld;


layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};

out vec4 fragColor;
uniform vec4 color;
uniform vec4 colorId;
uniform float select;
void main()
{
	if(select == 0){
		vec3 ambient = ambientStrength * lightColor;	
		vec3 norm = normalize(normals);
		vec3 lightDir = normalize(positionLightSource - positionInWorld);
		float diff = max(dot(norm, lightDir), 0.0);
		vec3 diffuse = diff * lightColor;
		//float specularStrength = 0.6f;
		//vec3 viewDir = normalize(positionLightSource - positionInWorld);
		//vec3 reflectDir = reflect(-lightDir, norm);
		//float spec = pow(max(dot(viewDir, reflectDir), 0.0), 8);
		//vec3 specular = specularStrength * spec * lightColor;
		vec3 result =  (ambient + diff) * vec3(color);
		fragColor = vec4(result, color.w); 
	}else{
		fragColor  = colorId;
	}	             
}