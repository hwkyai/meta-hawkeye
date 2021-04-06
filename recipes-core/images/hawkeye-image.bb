############################################################################
##
## Copyright (C) 2021 Hawkeye Recognition B.V.
## Contact: info@hwky.ai
##
############################################################################

DESCRIPTION = "A console-only base image"
LICENSE = "Apache-2.0"

IMAGE_FEATURES += "\
    ssh-server-openssh \
"

inherit core-image

CORE_IMAGE_BASE_INSTALL += "packagegroup-hawkeye-base"

# Add unprivileged 'hawkeye' user
inherit extrausers
HAWKEYE_USER ?= "hawkeye"
HAWKEYE_USER_PASSWORD ?= "hawkeye"
EXTRA_USERS_PARAMS += "\
    groupadd -f docker; \
    useradd -G docker \
    -p '$(openssl passwd -6 ${@ d.getVar('HAWKEYE_USER_PASSWORD')})' \
    ${@ d.getVar('HAWKEYE_USER')};"

# Set a password for the 'root' user
HAWKEYE_DEFAULT_ROOT_PASSWORD ?= "hawkeye"
do_rootfs[prefuncs] += "set_root_password"
python set_root_password() {
    rootpw = d.getVar("HAWKEYE_ROOT_PASSWORD")
    if rootpw is None:
        bb.warn("Using default password for root user. ",
                "You should set HAWKEYE_ROOT_PASSWORD to override.")
        d.setVar("HAWKEYE_ROOT_PASSWORD", d.getVar("HAWKEYE_DEFAULT_ROOT_PASSWORD"))

    # Do not update password if the variable is explicitly set as an empty string
    elif rootpw.strip() == "":
        bb.verbnote("Using empty password for root user.")
        return

    d.appendVar("EXTRA_USERS_PARAMS", "usermod -p '$(openssl passwd -6 %s)' root;"
                % d.getVar("HAWKEYE_ROOT_PASSWORD"))
}

# Install self-signed certificate for mender server
MENDER_SERVER_CERT ?= ""
IMAGE_INSTALL_append = " ${@'mender-server-certificate' if (d.getVar('MENDER_SERVER_CERT') != '') else ''}"
