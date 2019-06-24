#version 430


uniform vec3 uAmbientColor;
uniform vec3 uDiffuseColor;
uniform vec3 uSpecularColor;


layout (std140, binding = 4) uniform Mat
{
	vec3 positionLightSource;
   	mat4 projectionMatrix;
	mat4 viewMatrix;
    vec4 [39] colors;
};
in vec3 vPosition;
in vec3 vNormal;

uniform vec4 colorId;
uniform float select;

out vec4 fragColor;

void main() {
	if(select == 0){
	    vec3 ambientColor = uAmbientColor;
	    vec3 normal = normalize(vNormal);
	    vec3 lightDirection = normalize(positionLightSource - vPosition);
	    vec3 diffuseColor = max(0.0, dot(normal, lightDirection)) * uDiffuseColor;
	    vec3 reflectDirection = reflect(-lightDirection, normal);
	    vec3 specularColor = pow(max(dot(lightDirection, reflectDirection), 1), 0.1) * uSpecularColor;
	    fragColor = vec4(ambientColor + diffuseColor + specularColor, 1.0);
	}else{
		fragColor = colorId;
	}

}
