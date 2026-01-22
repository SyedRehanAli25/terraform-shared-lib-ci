def call(Map params) {
    def path = params.path
    echo "Running terraform init in ${path}"
    sh "terraform -chdir=${path} init -input=false"
}

