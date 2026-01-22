def call(Map params) {
    def path = params.path
    def env = params.env
    echo "Running terraform plan in ${path} for environment ${env}"
    sh "terraform -chdir=${path} plan -var-file=env/${env}.tfvars -out=${env}.tfplan"
}

