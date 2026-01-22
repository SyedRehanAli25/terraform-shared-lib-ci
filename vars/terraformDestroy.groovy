def call(Map args) {
    if (!args.path) {
        error "Please provide 'path' to terraformDestroy"
    }
    def varFile = args.varFile ?: ""
    echo "Running terraform destroy in ${args.path} with varFile ${varFile}"
    sh "terraform -chdir=${args.path} destroy -auto-approve ${varFile ? "-var-file=${varFile}" : ""}"
}
