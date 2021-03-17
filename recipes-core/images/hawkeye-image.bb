############################################################################
##
## Copyright (C) 2021 Hawkeye Recognition B.V.
## Contact: info@hwky.ai
##
############################################################################

DESCRIPTION = "A console-only base image"
LICENSE = "Apache-2.0"

IMAGE_FEATURES += "ssh-server-openssh"

inherit core-image

CORE_IMAGE_BASE_INSTALL += "packagegroup-hawkeye-base"

# Install self-signed certificate for mender server
MENDER_SERVER_CERT ?= ""
IMAGE_INSTALL_append = " ${@'mender-server-certificate' if (d.getVar('MENDER_SERVER_CERT') != '') else ''}"
