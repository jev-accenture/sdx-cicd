#!/usr/bin/env groovy
/**
 * ---  W O R K I N G  D I R E C T O R Y  P R E P A R A T I O N  ---
 *
 * The 'init' stage for Jenkins Pipeline
 *
 */

errors = 0

def main()
{

	try {
    sh "mkdir -p ${params.APPSRCDIR}"

    dir ("${params.APPSRCDIR}") {
      git(
        branch: "${params.APPBRANCH}",
        credentialsId: "${params.CREDENTIALSID}",
        url: "${params.APPREPO}"
      )

      /* install application libraries */
      sh 'pip install --user -r ./requirements.txt'
    }
	}
	catch (e) {
		echo 'ERROR: ' + e.toString()
		errors = 1
	}
}

main();

return errors;

