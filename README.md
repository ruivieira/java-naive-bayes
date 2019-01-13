# java-naive-bayes

A Java implementation of the [naïve bayes](https://nlp.stanford.edu/IR-book/html/htmledition/naive-bayes-text-classification-1.html)
algorithm.

## usage

Allow Maven to resolve bintray dependencies:

```xml
<profiles>
   <profile>
       <repositories>
           <repository>
               <snapshots>
                   <enabled>false</enabled>
               </snapshots>
               <id>bintray-ruivieira-maven</id>
               <name>bintray</name>
               <url>https://dl.bintray.com/ruivieira/maven</url>
           </repository>
       </repositories>
       <pluginRepositories>
           <pluginRepository>
               <snapshots>
                   <enabled>false</enabled>
               </snapshots>
               <id>bintray-ruivieira-maven</id>
               <name>bintray-plugins</name>
               <url>https://dl.bintray.com/ruivieira/maven</url>
           </pluginRepository>
       </pluginRepositories>
       <id>bintray</id>
   </profile>
</profiles>
<activeProfiles>
   <activeProfile>bintray</activeProfile>
</activeProfiles>
```

and the `java-naive-bayes` dependency:

```xml
<dependency>
  <groupId>org.ruivieira</groupId>
  <artifactId>naivebayes</artifactId>
  <version>0.0.1</version>
</dependency>
```