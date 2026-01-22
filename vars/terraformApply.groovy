def call(Map args) {
    if (!args.path) {
        error "Please provide 'path' to terraformApply"
    }
    def varFile = args.varFile ?: ""
    echo "Running terraform apply in ${args.path} with varFile ${varFile}"
    sh "terraform -chdir=${args.path} apply -input=false ${varFile ? "-var-file=${varFile}" : ""} terraform.tfplan"
}
