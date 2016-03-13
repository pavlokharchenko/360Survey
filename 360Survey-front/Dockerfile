FROM ubuntu:latest

MAINTAINER Pavlo Kharchenko <pavel.kharchenko@gmail.com>

RUN lsb_release -a
RUN apt-get update && apt-get install curl -y && apt-get install -y \
    && curl --silent --location https://deb.nodesource.com/setup_5.x | sudo bash - \
    && apt-get install -y nodejs \
    && rm -rf /var/lib/apt/lists/*

CMD [ "nodejs", "--version" ]
CMD [ "npm", "--version" ]

# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

# Install app dependencies
COPY package.json /usr/src/app
CMD [ "npm", "install" ]

# Copy app sources
COPY . /usr/src/app

# Map port
EXPOSE 3000

# Run application
CMD [ "npm", "start" ]