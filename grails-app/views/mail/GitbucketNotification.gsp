<%@ page import="grails.converters.JSON" %>
<%@ page contentType="text/plain"%>
Pushes executed by: ${data.pusher.name}
Repository: ${data.repository.name} (${data.repository.url})
<g:each var="commit" in="${data.commits}">
---------
Timestamp: ${commit.timestamp}
Link:      ${commit.url}
Committer: ${commit.author.name}
Log:       ${commit.message}
</g:each>
