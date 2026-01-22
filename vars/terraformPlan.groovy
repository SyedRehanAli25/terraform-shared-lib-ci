def call(Map args) {
    if (!args.path) {
        error "Please provide 'path' to terraformPlan"
    }
    def varFile = args.varFile ?: ""
    echo "Running terraform plan in ${args.path} with varFile ${varFile}"
    sh "terraform -chdir=${args.path} plan -out=terraform.tfplan ${varFile ? "-var-file=${varFile}" : ""}"
}
