#!/usr/bin/env groovy
/**
 * ---  I M A G E  P R E P A R A T I O N  ---
 *
 * The 'build' stage for Jenkins Pipeline
 *
 */

errors = 0

def main()
{
  try {
    build job: "${params.APPBUILDJOB}"
  }
  catch (e) {
    echo 'ERROR: ' + e.toString()
    errors = 1
  }
}

main();

return errors;

