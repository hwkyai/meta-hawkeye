# meta-hawkeye

This layer is the main distro layer for HawkeyeOS, based on the Yocto poky reference distribution and [OE4T/tegra-demo-distro][tegra-demo-distro].

The majority of this layer's work is accomplished in bbappend files, used to adapt existing recipes for HawkeyeOS.

## Using the meta-hawkeye layer

This layer is typically used in a device-specific repository such as [hawkeyeos-jetson][hawkeyeos-jetson].

## Contributing

Please refer to [CONTRIBUTING](CONTRIBUTING.md)

## License

All metadata is Apache-2.0 licensed unless otherwise stated. Source code included
in tree for individual recipes is under the LICENSE stated in each recipe
(.bb file) unless otherwise stated.

[tegra-demo-distro]:https://github.com/OE4T/tegra-demo-distro
[hawkeyeos-jetson]:https://github.com/hwkyai/hawkeyeos-jetson
