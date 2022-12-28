#add plugin pom file 
# ${project.artifactId} -docker image jar file name
# <args>/maven/${project.artifactId}-${project.version}.jar</args> -projenin bu isimde bir jar dosyası oluşur. 
# <from>java:8-jdk-alpine</from> --bize bir linux image verecek üzerine bir de java 8 kuracak. 
# entryPoint -> container başlattığımızda container içerisinde nasıl kod çalıştırılacaksa o olur. 
#console üzerinden docker images yazdığımızda imajımızı görürüz.
# yine console üzerinden docker run -p 8080:8080 spring-boot-dockerization yazdığımızda 8080 portundan yayınlarız. localimizden


<plugin>
       <groupId>io.fabric8</groupId>
                <artifactId>docker-maven-plugin</artifactId>
                <version>0.26.0</version>
                <extensions>true</extensions>
                <configuration>
                    <verbose>true</verbose>
                    <images>
                        <image>
                            <name>${project.artifactId}</name>
                            <build>
                                <from>java:8-jdk-alpine</from>
                                <entryPoint>
                                    <exec>
                                        <args>java</args>
                                        <args>-jar</args>
                                        <args>/maven/${project.artifactId}-${project.version}.jar</args>
                                    </exec>
                                </entryPoint>
                                <assembly>
                                    <descriptorRef>artifact</descriptorRef>
                                </assembly>
                            </build>
                        </image>
                    </images>
                </configuration>
                <executions>
                    <execution>
                        <id>build</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>build</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>