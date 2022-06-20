def call(Map params = null, Closure body = null) {
    def label = "tvaas-cd"
    def cloud = (params?.cloud ? params.cloud : "kubernetes")
    def cluster = (params?.cluster ? params.cluster : params.env)
    def componentName = (params?.componentName ? params.componentName : currentBuild.projectName).toString().toLowerCase()

    println("Environment is " + cluster)
    println("componentName is " + componentName)

    /*node(label) {
        try {
            ansiColor("xterm") {
                if (!body) {
                    echo "!body()"
                } else {
                    echo "body()"
                    body()
                }
            }
        } catch (err) {
            // DO SOME ACTIONS HERE...
            echo "Caught: ${err}"
            //error(err.getMessage())
        } finally {
            // DO SOME ACTIONS HERE...
        }
    }*/

    pipeline {
        agent any

        stages {
            stage('Hello') {
                steps {
                    echo 'Hello World'
                }
            }
        }
    }

}
