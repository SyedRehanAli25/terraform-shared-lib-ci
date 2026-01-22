def call(Map params) {
    def path = params.path
    def env = params.env
    echo "Applying terraform plan in ${path} for environment ${env}"
    sh "terraform -chdir=${path} apply -input=false env/${env}.tfplan"
}

