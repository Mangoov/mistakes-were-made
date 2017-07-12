## Consider SecretFeature as coming from a Gem
def some_display_helper
  if Feature.beta.enabled(:some_beta_flag) && SecretFeature::Helper.isEligible?(customer)
    do_something
  end
end

## Beta flag removal ##

def some_display_helper
  if SecretFeature::Helper.isEligible?(customer)
    do_something
  end
end

## The error here is that this code would be re-used in
## localized instances of the website each of which defined
## their own gem dependencies. So once this code was pushed
## The localized instances that didn't have the SecretFeature
## gem would explode.

