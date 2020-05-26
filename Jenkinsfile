pipeline {
   agent any

   stages {
      stage('pull code') {
         steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '111f9a53-039b-4134-a12a-467af5cfc645', url: 'git@github.com:git-jxj/Test.git']]])
         }
      }
      stage('build') {
         steps {
             sh 'mvn clean package -Dmaven.test.skip=true dockerfile:build'
         }
      }
      //stage('docker build push') {
         //steps {
             //sh "docker tag demo 49.233.11.217:5000/demo"
             //sh "docker push 49.233.11.217:5000/demo"
         //}
      //}
      stage('docker run') {
         steps {
              sh 'docker run -d -p 8080:8080 --name demo demo'
         }
      }
   }
}
