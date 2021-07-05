SUMMARY = "Software components for base images"
PR = "r1"

#
# packages which content depend on MACHINE_FEATURES need to be MACHINE_ARCH
#
PACKAGE_ARCH = "${MACHINE_ARCH}"

LICENSE = "Apache-2.0"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = ' \
            ${PN}-base \
            ${PN}-dev \
            '

RDEPENDS_${PN}-base = " \
    haveged \
    procps \
    less \
    kernel-module-wireguard \
    docker-ce \
    python3-docker-compose \
    data-overlay-setup \
"

RDEPENDS_${PN}-dev = " \
    systemd-analyze \
    strace \
    tmux \
"
