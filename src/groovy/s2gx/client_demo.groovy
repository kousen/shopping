package s2gx

import groovyx.net.http.RESTClient
import groovyx.net.http.ContentType

def client = new RESTClient(
        'http://localhost:8080/shopping/',
        ContentType.JSON)
def response = client.get(path:'products')
assert 200 == response.status
assert 'application/json' == response.contentType
println response.data