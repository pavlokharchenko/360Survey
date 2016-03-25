FROM tomcat:8.0.32-jre8

MAINTAINER Taras Danylchuk "danylchuktv@gmail.com"

# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

# Update aptitude with new repo
RUN apt-get update

# Install Tools 
RUN apt-get install -y git
RUN apt-get install -y gradle
RUN apt-get -y install ssh

# ----------------------------------------- Start of JDK 8 Installing -----------------------------------------
RUN apt-get update && apt-get install -y --no-install-recommends \
		bzip2 \
		unzip \
		xz-utils \
	&& rm -rf /var/lib/apt/lists/*

RUN echo 'deb http://httpredir.debian.org/debian jessie-backports main' > /etc/apt/sources.list.d/jessie-backports.list

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8

# add a simple script that can auto-detect the appropriate JAVA_HOME value
# based on whether the JDK or only the JRE is installed
RUN { \
		echo '#!/bin/sh'; \
		echo 'set -e'; \
		echo; \
		echo 'dirname "$(dirname "$(readlink -f "$(which javac || which java)")")"'; \
	} > /usr/local/bin/docker-java-home \
	&& chmod +x /usr/local/bin/docker-java-home

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64

ENV JAVA_VERSION 8u72
ENV JAVA_DEBIAN_VERSION 8u72-b15-1~bpo8+1
ENV CA_CERTIFICATES_JAVA_VERSION 20140324

RUN set -x \
	&& apt-get update \
	&& apt-get install -y \
		openjdk-8-jdk="$JAVA_DEBIAN_VERSION" \
		ca-certificates-java="$CA_CERTIFICATES_JAVA_VERSION" \
	&& rm -rf /var/lib/apt/lists/* \
	&& [ "$JAVA_HOME" = "$(docker-java-home)" ]

# see CA_CERTIFICATES_JAVA_VERSION notes above
RUN /var/lib/dpkg/info/ca-certificates-java.postinst configure
# ----------------------------------------- End of JDK 8 Installing -----------------------------------------

# Make ssh dir
RUN mkdir /root/.ssh/
# Create known_hosts
RUN touch /root/.ssh/known_hosts
# Copy private SSH key
ADD id_rsa /root/.ssh/id_rsa
ADD id_rsa.pub /root/.ssh/id_rsa.pub
RUN chmod 600 /root/.ssh/id_rsa
# Add github to know hosts
RUN ssh-keyscan -t rsa github.com >> /root/.ssh/known_hosts
ENV TERM=${TERM:-dumb}

# clone project from GitHub
RUN git clone git@github.com:pavlokharchenko/360Survey.git survey-backend

# Build project
WORKDIR /usr/src/app/survey-backend/Backend
RUN gradle war

# Deploy war
RUN cp /usr/src/app/survey-backend/Backend/build/libs/Backend-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/survey-backend.war

