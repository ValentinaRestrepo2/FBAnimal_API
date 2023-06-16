# Utiliza una imagen base que contenga Java y Tomcat
FROM tomcat:9.0-jdk11
# Copia el archivo WAR generado por el proyecto JSP al directorio webapps de Tomcat
COPY ./Fundacion_BA/*.war /usr/local/tomcat/webapps/
EXPOSE 8080
# Comando para iniciar Tomcat cuando el contenedor se ejecute
CMD ["catalina.sh", "run"]
