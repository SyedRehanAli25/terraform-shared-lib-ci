def call(Map params) {
    def path = params.path
    def env = params.env
    echo "Destroying terraform resources in ${path} for environment ${env}"
    sh "terraform -chdir=${path} destroy -var-file=env/${env}.tfvars -auto-approve"
}

