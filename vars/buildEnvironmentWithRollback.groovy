def call(Map params = null, Closure body = null) {
    def label = "tvaas-cd"
    def cloud = (params?.cloud ? params.cloud : "kubernetes")
    def cluster = (params?.cluster ? params.cluster : params.env)
    def componentName = (params?.componentName ? params.componentName : currentBuild.projectName).toString().toLowerCase()

    println("Environment is " + cluster)
    println("componentName is " + componentName)
}
