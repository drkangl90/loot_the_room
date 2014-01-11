package com.toastercat.loottheroom.game;

public class Character
{
    private int iSpecialization;
    private int iAttribute;

    // Attributes
    //modified
    private float fHealthModifier;
    private float fDevraModifier;
    private float fStaminaModifier;
    //base
    private float fHealth;
    private float fDevra;
    private float fStamina;

    // Skill
    private float fEnergyWeapons;
    private float fExplosives;
    private float fGuns;
    private float fMeleeWeapons;
    private float fUnarmed;
    private float fHeavyArmor;
    private float fBarter;
    private float fMedicine;
    private float fRepair;
    private float fSpeech;
    private float fLightArmor;

    // Skill Modifier
    private float fEnergyWeaponsModifier;
    private float fExplosivesModifier;
    private float fGunsModifier;
    private float fMeleeWeaponsModifier;
    private float fUnarmedModifier;
    private float fHeavyArmorModifier;
    private float fBarterModifier;
    private float fMedicineModifier;
    private float fRepairModifier;
    private float fSpeechModifier;
    private float fLightArmorModifier;

    // Skill Rates
    private double dEnergyWeaponsSkillRate;
    private double dExplosivesSkillRate;
    private double dGunsSkillRate;
    private double dMeleeWeaponsSkillRate;
    private double dUnarmedSkillRate;
    private double dHeavyArmorSkillRate;
    private double dBarterSkillRate;
    private double dMedicineSkillRate;
    private double dRepairSkillRate;
    private double dSpeechSkillRate;
    private double dLightArmorSkillRate;

    public Character()
    {
        fHealth = 100;
        fDevra = 100;
        fStamina = 100;

        fEnergyWeapons = 15;
        fExplosives = 15;
        fGuns = 15;
        fMeleeWeapons = 15;
        fUnarmed = 15;
        fHeavyArmor = 15;
        fBarter = 15;
        fMedicine = 15;
        fRepair = 15;
        fSpeech = 15;
        fLightArmor = 15;
    }

    // ----------------------------------------------------------
    /**
     * Assigns the attributes and skills to the character
     */
    public void AssignAllStats()
    {
        ApplySkillValues();
        ApplyAttributes();
    }

    /**
     * applies an increase to attributes
     */
    public void ApplyAttributes()
    {
        // TODO Auto-generated method stub
        // get the base attribute and add modified
        fHealth = fHealth + fHealthModifier;
        fDevra = fDevra + fDevraModifier;
        fStamina = fStamina + fStaminaModifier;
    }

    /**
     * unapply an increase to attributes
     */
    public void UnapplyAttributes()
    {
     // get the base attribute and minus modified
        fHealth = fHealth - fHealthModifier;
        fDevra = fDevra - fDevraModifier;
        fStamina = fStamina - fStaminaModifier;
    }

    private void ApplySkillValues()
    {
        // TODO Auto-generated method stub
        // get base skill and add modified
        fEnergyWeapons = fEnergyWeapons + fEnergyWeaponsModifier;
        fExplosives = fExplosives + fExplosivesModifier;
        fGuns = fGuns + fGunsModifier;
        fMeleeWeapons = fMeleeWeapons + fMeleeWeaponsModifier;
        fUnarmed = fUnarmed + fUnarmedModifier;
        fHeavyArmor = fHeavyArmor + fHeavyArmorModifier;
        fBarter = fBarter + fBarterModifier;
        fMedicine = fMedicine + fMedicineModifier;
        fRepair = fRepair + fRepairModifier;
        fSpeech = fSpeech + fSpeechModifier;
        fLightArmor = fLightArmor + fLightArmorModifier;
    }


    // ----------------------------------------------------------
    /**
     * Resets the attributes to 0
     */
    public void resetAttributeModifiers()
    {
        fHealthModifier = 0;
        fDevraModifier = 0;
        fStaminaModifier = 0;
    }

    /**
     * resets the skill values to 0
     */
    public void resetSkillValueModifiers()
    {
        fEnergyWeaponsModifier = 0;
        fExplosivesModifier = 0;
        fGunsModifier = 0;
        fMeleeWeaponsModifier = 0;
        fUnarmedModifier = 0;
        fHeavyArmorModifier = 0;
        fBarterModifier = 0;
        fMedicineModifier = 0;
        fRepairModifier = 0;
        fSpeechModifier = 0;
        fLightArmorModifier = 0;
    }

    public void setSkillValueModifiers()
    {
        int aiElement = 0;
    }
    /**
     * resets the skill rates to 100%
     */
    public void resetSkillRates()
    {
        dEnergyWeaponsSkillRate = 1.00;
        dExplosivesSkillRate = 1.00;
        dGunsSkillRate = 1.00;
        dMeleeWeaponsSkillRate = 1.00;
        dUnarmedSkillRate = 1.00;
        dHeavyArmorSkillRate = 1.00;
        dBarterSkillRate = 1.00;
        dMedicineSkillRate = 1.00;
        dRepairSkillRate = 1.00;
        dSpeechSkillRate = 1.00;
        dLightArmorSkillRate = 1.00;
    }

}
