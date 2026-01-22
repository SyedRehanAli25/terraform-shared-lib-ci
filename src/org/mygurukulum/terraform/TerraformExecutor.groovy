package org.mygurukulum.terraform

class TerraformExecutor implements Serializable {

    def steps

    TerraformExecutor(steps) {
        this.steps = steps
    }

    def init(Map params = [:]) {
        def path = params.get('path', '.')
        steps.sh "cd ${path} && terraform init"
    }

    def validate(Map params = [:]) {
        def path = params.get('path', '.')
        steps.sh "cd ${path} && terraform validate"
    }

    def plan(Map params = [:]) {
        def path = params.get('path', '.')
        def outFile = params.get('out', 'plan.tfplan')
        steps.sh "cd ${path} && terraform plan -out=${outFile}"
    }

    def apply(Map params = [:]) {
        def path = params.get('path', '.')
        def planFile = params.get('plan', 'plan.tfplan')
        steps.sh "cd ${path} && terraform apply ${planFile}"
    }

    def destroy(Map params = [:]) {
        def path = params.get('path', '.')
        steps.sh "cd ${path} && terraform destroy -auto-approve"
    }
}
