############################################################################
##
## Copyright (C) 2021 Hawkeye Recognition B.V.
## Contact: info@hwky.ai
##
############################################################################

DESCRIPTION = "A console-only base image for development"

require hawkeye-image.bb

IMAGE_FEATURES += "debug-tweaks"

CORE_IMAGE_BASE_INSTALL += "packagegroup-hawkeye-dev"
