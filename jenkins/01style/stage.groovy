#!/usr/bin/env groovy
/**
 * ---  C O D E  S T Y L E  T E S T S  ---
 *
 * The 'style' stage for Jenkins Pipeline
 *
 */

errors = 0

def main()
{
  try {
    sh "flake8 ./${params.APPSRCDIR}/app/ | sed 's|^./*||' > flake8.log"
    sh "cat ./flake8.log"

    step([
      $class: 'WarningsPublisher',
      parserConfigurations: [[
        parserName: 'Pep8',
        pattern: '**/flake8.log'
      ]],
      unstableTotalAll: '0',
      usePreviousBuildAsReference: true
    ])
  }
	catch (e) {
		echo 'ERROR: ' + e.toString()
		errors = 1
	}
}

main();

return errors;

