FROM openjdk:8-jre
ADD ./build/distributions/Pancake.tar /usr/src/
WORKDIR /usr/src/Pancake
CMD ["/usr/src/Pancake/bin/Pancake"]
