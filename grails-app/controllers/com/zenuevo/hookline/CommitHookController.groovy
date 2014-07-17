package com.zenuevo.hookline

import grails.converters.JSON
import grails.plugin.mail.MailService
import org.codehaus.groovy.grails.web.json.JSONObject

import javax.servlet.http.HttpServletRequest

class CommitHookController
{

    def grailsApplication
    def MailService mailService
    def groovyPageRenderer

    def processCommit(String payload)
    {

        println params.destination

        def data = JSON.parse(payload)
//        String gspOutput = groovyPageRenderer.render(
//                view: "/mail/GitbucketNotification",
//                model: [data: data]
//        )
//      println("\n\n$gspOutput\n\n")

        mailService.sendMail {
            async true
            to params.destination
            from "Gitbucket <pogy@ern.nps.edu>"
            subject "${data.pusher.name} pushed to repository ${data.repository.name}"
            body(view: "/mail/GitbucketNotification", model: [data: data])
        }


    }
}
