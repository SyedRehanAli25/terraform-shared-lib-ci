def call(Map args = [:]) {
    def path = args.path
    def backendReconfigure = args.get('backendReconfigure', false)

    def reconfigureFlag = backendReconfigure ? "-reconfigure" : ""

    sh "terraform -chdir=${path} init -input=false -backend=true ${reconfigureFlag}"
}
