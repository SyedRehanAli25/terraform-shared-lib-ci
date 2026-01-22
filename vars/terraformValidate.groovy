def call(Map params) {
    def path = params.path
    echo "Running terraform validate in ${path}"
    sh "terraform -chdir=${path} validate"
}

