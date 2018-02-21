#!/usr/bin/env groovy
/**
 * ---  F U N C T I O N  T E S T S  ---
 *
 * The 'test' stage for Jenkins Pipeline
 *
 */

errors = 0

def main()
{
  try {
    /* run code analysis and tests */
    sh "pytest --junitxml=./junit.xml ./${params.APPSRCDIR}/app/"
    sh "coverage run --source=./${params.APPSRCDIR}/app -m py.test ./${params.APPSRCDIR}/app/"

    /* create reports */
    sh "coverage xml --include=./${params.APPSRCDIR}/app*"
    sh "coverage report -m --include=./${params.APPSRCDIR}/app*"
	}
	catch (e) {
		echo 'ERROR: ' + e.toString()
		errors = 1
	}
}

main();

return errors;

