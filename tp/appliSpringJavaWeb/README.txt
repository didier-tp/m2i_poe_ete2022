profiles spring de cette application:

- "remoteDB" (avec base distante gérée par un serveur MySql ou PostgresSql ou ...)
   ou "embeddedDB" (avec base de données embarquée telle que H2)
- "perf" declenche l'aspect mesurer et afficher les temps d'executions (MyPerfLogAspect)
- "dev" ou "prod"
- ...


========================
possibilités maven:

-DskipTests=true
-Dmaven.test.failure.ignore=true
--fail-at-end

=====================

<profiles>
  <profile>
    <id>env.FOO</id>
    <activation>
      <property>
        <name>!env.FOO</name>
      </property>
    </activation>
    <properties>
      <env.FOO>default_FOO</env.FOO>
    </properties>
  </profile>
</profiles>

et de l'exterieur set FOO=v1 ou export FOO=v1 ou -Denv.FOO=v1


<plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-javadoc-plugin</artifactId>
        <version>3.4.1</version>
        <configuration>
          <reportOutputDirectory>${env.OUTPUT_JAVADOC_DIR}</reportOutputDirectory>
          <destDir>myapidocs</destDir>
          ...
        </configuration>
      </plugin>
      
=================

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-resources-plugin</artifactId>
    <version>3.2.0</version>  <!-- ou bien 3.1.0 --> 
    <configuration>
        <propertiesEncoding>UTF-8</propertiesEncoding>
        <nonFilteredFileExtensions>
            <nonFilteredFileExtension>xls</nonFilteredFileExtension>
            <nonFilteredFileExtension>xlsx</nonFilteredFileExtension>
        </nonFilteredFileExtensions>
    </configuration>
</plugin>

et attention aux caractères accentués et aux sauts de lignes (linux/windows)      

===========
NB: dans un pipeline de jenkins , la partie Tools ne fait que fixer le PATH en fonction d'une partie Tools de jenkins à configurer