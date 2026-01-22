def call(Map args) {
    if (!args.path) {
        error "Please provide 'path' to terraformValidate"
    }
    echo "Running terraform validate in ${args.path}"
    sh "terraform -chdir=${args.path} validate"
}
