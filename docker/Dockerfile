FROM jenkins/jenkins:lts

ARG user=jenkins

USER root

RUN apt-get update && apt-get install -y python-pip && rm -rf /var/lib/apt/lists/*

RUN pip install requests coverage flake8 pep8-naming pytest pytest-timeout mock


USER ${user}

