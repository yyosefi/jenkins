#!/usr/bin/env groovy
package com.utilities

import groovy.json.JsonSlurperClassic

static Object parseStringToJson(String fileContent) {
    def jsonSlurperClassic = new JsonSlurperClassic()
    def Object = jsonSlurperClassic.parseText(fileContent)
    return Object
}

def updateFile(String tag, String value, String fileName) {
    sh "sed -i 's/${tag}/${value}/g' ${fileName}"
}

def sendMailToGitlabUser(String JOB_NAME, String BUILD_NUMBER, String BUILD_URL, String gitlabUserEmail, String gitlabUserName, String gitlabBranch, String Result, String cc) {
    if (gitlabUserEmail != null) {
        mail bcc: '', body: "<b>Your Pipeline has ${Result}</b><br>Project: ${JOB_NAME} <br>Build Number: ${BUILD_NUMBER} <br>Branch: ${gitlabBranch}<br>Commit Author: ${gitlabUserName}<br>Build URL: ${BUILD_URL}testReport/", cc: cc, charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "${JOB_NAME} | CI Pipeline #${BUILD_NUMBER} has ${Result} for Branch  ${gitlabBranch}", to: gitlabUserEmail
    } else {
        echo JOB_NAME + " was not triggered by GitLab - not sending mail"
    }
}

def checkUrl(String url) {
    String status = sh(script: "curl -s -o /dev/null -w '%{http_code}' --connect-timeout 5 ${url}", returnStdout: true)
    return status == '200'
}
