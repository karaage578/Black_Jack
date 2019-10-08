FROM gitpod/workspace-full

### Java & Maven ###
RUN add-apt-repository -yu ppa:webupd8team/java \
    && echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections \
    && apt-get install -yq \
        gradle \
        oracle-java8-installer \
    && apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/*

ARG MAVEN_VERSION=3.5.4
ENV MAVEN_HOME=/usr/share/maven
ENV PATH=$MAVEN_HOME/bin:$PATH
RUN mkdir -p $MAVEN_HOME \
    && curl -fsSL https://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz \
        | tar -xzvC $MAVEN_HOME --strip-components=1