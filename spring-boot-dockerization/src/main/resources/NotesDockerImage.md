io.fabric8 docker-maven-plugin 0.26.0 true true


${project.artifactId} java:8-jdk-alpine java -jar 
/maven/${project.artifactId}-${project.version}.jar 
artifact build post-integration-test build