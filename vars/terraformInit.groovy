// vars/terraformInit.groovy
def call(Map args) {
    if (!args.path) {
        error "Please provide 'path' to terraformInit"
    }
    echo "Running terraform init in ${args.path}"
    sh "terraform -chdir=${args.path} init -input=false -backend=true"
}
